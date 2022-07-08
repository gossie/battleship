import axios, { AxiosResponse } from "axios";
import { Board, Game, Ship } from "./model";

export function startNewGame() {
    return axios.post("/api/games")
        .then((response: AxiosResponse<Game>) => response.data)
}

export function getGame(id: string) {
    return axios.get(`/api/games/${id}`)
        .then((response: AxiosResponse<Game>) => response.data)
}

export function addShip(board: Board, ship: Ship) {
    const url = board.links.find(link => link.rel === 'addShip')?.href
    return axios.post(url!, ship)
        .then((response: AxiosResponse<Game>) => response.data)
}
