import { useEffect, useState } from "react";

function GridComponent(gridData){

    const {gridNo, updatedPlayersInGrid} = gridData.data;
    useEffect(() => {
        setPlayersInGrid(updatedPlayersInGrid);

    },[])

    const [playersInGrid, setPlayersInGrid] = useState(null);


    return (
        <div
          style={{
            border: "0px",
            borderRadius: "5px",
            height: "56px",
            width: "56px",
            position: "relative",
            background: gridNo % 2 === 0 ? "beige" : "green",
            display: "inline-block"
          }}
        >
          <span>{gridNo}</span>
          { (playersInGrid || []).map((p) => (
            <div key={p.id} style={{ fontSize: "12px" }}>
                <img src="sfsfd" alt={ "player" + p.id} />
            </div>
          ))}
        </div>
      );
}

export default GridComponent;