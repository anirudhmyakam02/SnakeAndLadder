import { Link } from 'react-router-dom'

function HomePage() {
  return (
    <div style={{ minHeight: '100vh', display: 'flex', alignItems: 'center', justifyContent: 'center', background: '#f3f4f6', padding: '24px' }}>
      <div style={{ maxWidth: '560px', width: '100%', background: 'white', padding: '32px', borderRadius: '16px', boxShadow: '0 10px 30px rgba(0,0,0,0.08)', textAlign: 'center' }}>
        <h1 style={{ fontSize: '2rem', marginBottom: '12px', color: '#111827' }}>Snake & Ladder</h1>
        <p style={{ fontSize: '1rem', lineHeight: 1.6, color: '#4b5563', marginBottom: '24px' }}>
          Welcome to the game lobby. Create a room, join a match, or jump into the game flow.
        </p>

        <div style={{ display: 'flex', gap: '12px', justifyContent: 'center', flexWrap: 'wrap' }}>
          <Link to="/login" style={{ textDecoration: 'none', padding: '10px 16px', borderRadius: '8px', background: '#2563eb', color: 'white' }}>
            Login
          </Link>
          <Link to="/register" style={{ textDecoration: 'none', padding: '10px 16px', borderRadius: '8px', background: '#111827', color: 'white' }}>
            Register
          </Link>
          <Link to="/room" style={{ textDecoration: 'none', padding: '10px 16px', borderRadius: '8px', border: '1px solid #d1d5db', color: '#111827' }}>
            Go to Room
          </Link>
        </div>
      </div>
    </div>
  )
}

export default HomePage
