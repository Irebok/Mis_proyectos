export interface Usuario {
    _id?: string,
    ID_usuario: Number,

    rol?: {
        type: String,
        enum: ["administrador", "cliente"]
    }                    
               
}