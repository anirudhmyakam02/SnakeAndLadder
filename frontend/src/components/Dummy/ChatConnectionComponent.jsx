import React, { useEffect, useState, useRef } from "react";
// import SockJS from "sockjs-client";
import { Client } from "@stomp/stompjs";
import customAxios from "../../utils/customAxios";

const ChatComponent = () => {
  const [username, setUsername] = useState("");
  const [message, setMessage] = useState("");
  const [messages, setMessages] = useState([]);
  const stompClientRef = useRef(null);

  const [ receiver, setReceiver] = useState("");
  const [ personalMessage, setPersonalMessage] = useState("");

  useEffect(() => {
    connect();
  }, []);

  const connect = () => {
    // const socket = new SockJS("http://localhost:8080/ws");

    console.log("calling connection")
    console.log(localStorage.getItem("token"))
    const client = new Client({
      brokerURL: "ws://localhost:8080/ws",
      connectHeaders: {
        Authorization: `Bearer ${localStorage.getItem("token")}`
      },
      reconnectDelay: 5000,
      onConnect: () => {
        console.log("Connected to WebSocket");

        client.subscribe("/topic/public", (response) => {
          const body = JSON.parse(response.body);
          console.log(body);
          setMessages((prev) => [...prev, body]);
        });

        client.subscribe("/user/queue/private", (message) => {
          console.log("Private message:", JSON.parse(message.body));
        });

        const response = customAxios.get(
          "/player/me"
        ).then((res) => { console.log(res)})
      },
    });

    client.activate();
    stompClientRef.current = client;
  };

  // 🔹 Add user
  const registerUser = () => {
    stompClientRef.current.publish({
      destination: "/app/addUser",
      body: JSON.stringify({
        sender: username,
        type: "JOIN",
      }),
    });
  };

  // 🔹 Send message
  const sendMessage = () => {
    if (message.trim() !== "") {
      stompClientRef.current.publish({
        destination: "/app/sendMessage",
        body: JSON.stringify({
          sender: username,
          message: message,
          type: "CHAT",
        }),
      });

      setMessage("");
    }
  };

  const sendPersonalMessage = () => {
    if (personalMessage.trim() !== "") {
      stompClientRef.current.publish({
        destination: "/app/sendPrivateMessage",
        body: JSON.stringify({
          recipient: receiver,
          sender: username,
          message: personalMessage,
          type: "CHAT",
        }),
      });

      setPersonalMessage("");
    }
  }

  return (
    <div style={{ padding: "20px" }}>
      <h2>WebSocket Chat</h2>

      <div>
        <input
          type="text"
          placeholder="Enter username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <button onClick={registerUser}>Join</button>
      </div>

      <div style={{ marginTop: "20px" }}>
        <input
          type="text"
          placeholder="Enter message"
          value={message}
          onChange={(e) => setMessage(e.target.value)}
        />
        <button onClick={sendMessage}>Send</button>
      </div>

      <div>
        <h2>personal message</h2>
        <input 
          type="text"
          placeholder="receiver username"
          value={receiver}
          onChange={(e) => setReceiver(e.target.value)}
          />

        <input 
          type="text"
          placeholder="enter message"
          value={personalMessage}
          onChange={(e) => setPersonalMessage(e.target.value)} 
          />

          <button onClick={sendPersonalMessage}>send</button>
      </div>

      <div style={{ marginTop: "20px" }}>
        <h3>Messages</h3>
        {messages.map((msg, index) => (
          <div key={index}>
            <strong>{msg.sender}</strong>: {msg.message}
          </div>
        ))}
      </div>
    </div>
  );
};

export default ChatComponent;
