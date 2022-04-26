const express = require('express');
const app = express();
const mongoose = require ('mongoose');
const cors = require('cors');
const axios = require('axios');
const PORT = 3000;


mongoose.connect("mongodb://localhost:27017/tienda");

app.use(express.json());

app.use(express.urlencoded({
    extended : true
}));

app.use(cors());

require('./app/funciones.js')(app);


app.listen(PORT, () => {
    console.log(`Servidor corriendo en el puerto ${PORT}`)
});

/****************************Relacionado con la conexion a la base de datos************************/ 
var db = mongoose.connection;


db.on('error', function(err){
    console.log('Error en la conexion a la base datos',err)
})

db.once('open', function(){
    console.log('Conexion a la base de datos establecida...')
    
})
