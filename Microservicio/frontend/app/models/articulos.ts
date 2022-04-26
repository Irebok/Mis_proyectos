export interface Articulo {
    _id: string,
    ID?: Number,
                asignatura: String,
                curso_academico: {
                    curso: string,
                    cuatri: string
                },
                profesorado: {
                    profesor?: String,
                    departamento?: String
                },
                idioma?: {
                    type: String,
                    enum: ["español", "galego", "ingles"]
                },
                autor?: String , 
                tipo?: {
                    type: String,
                    enum: ["teoria", "practica"]
                },
                cantidad?: Number,
                precio? : Number
}