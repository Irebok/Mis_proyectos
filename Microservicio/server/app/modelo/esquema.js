var mongoose = require('mongoose');

module.exports = mongoose.model('Tienda', 
        {
            ID: Number,
                asignatura: String,
                curso_academico: {
                    curso: String,
                    cuatri: String
                },
                profesorado: {
                    profesor: String,
                    departamento: String
                },
                idioma: {
                    type: String,
                    enum: ["español", "galego", "ingles", "", null]
                },
                autor: String , 
                tipo: {
                    type: String,
                    enum: ["teoria", "practica", "", null]
                },
                cantidad: Number,
                precio : Number
    
        });

