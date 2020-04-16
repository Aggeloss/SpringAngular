export class User {
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    token?: string;

    constructor(id: number, username: string, token: string) {
        this.id = id;
        this.username = username;
        this.token = token;
    }
}
