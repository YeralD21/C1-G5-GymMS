export interface User {
    id: number;
    name: string;
    role: string;
}

export const Roles = {
    ADMIN: 'admin',
    USER: 'user'
};
