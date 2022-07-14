import { Player } from "../service/model"

interface PlayersProps {
    players: Array<Player>
}

export default function Players(props: PlayersProps) {
    return (
        <div>
            {props.players.map(player => <div key={player.name}>{player.name}</div>)}
        </div>
    )
}