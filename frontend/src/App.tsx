import { BrowserRouter, Route, Routes } from "react-router-dom";
import GamePage from "./pages/GamePage";
import LandingPage from "./pages/LandingPage";

function App() {

    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<LandingPage />} />
                <Route path="/game/:id" element={<GamePage />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
