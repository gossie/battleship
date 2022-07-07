export interface Game {
    id: string
    board: Board
    links: Array<Link>
}

export interface Board {
    fields: Array<Array<Field>>
}

export interface Field {

}

interface Link {
    href: string
    rel: string
}