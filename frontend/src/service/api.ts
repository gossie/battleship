import axios, { AxiosResponse } from "axios";
import { Game } from "./model";

export function startNewGame() {
    return axios.post("/api/games")
        .then((response: AxiosResponse<Game>) => response.data)
}

export function getGame(id: string) {
    return axios.get(`/api/games/${id}`)
        .then((response: AxiosResponse<Game>) => response.data)
}
