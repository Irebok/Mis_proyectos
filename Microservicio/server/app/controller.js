var Tienda = require ('./modelo/esquema');
var axios = require ('axios');

exports.getPrincipal = function (request, response) {

    response.send('<h1>Hola admin</h1>');

}

exports.getID = function (request, response) {

    let id = String(request.params.id);

    Tienda.find({'_id' : id}).exec(function(error, articulo){
        if(error) {
            console.log("Error al buscar con get");
            response.send("Error al buscar");
        }
        response.send(articulo);
    })
}

exports.getArticulo = function (request, response) {

    let curso = request.query.curso;
    let cuatri = request.query.cuatri;

    Tienda.find({
        curso_academico : {
            curso: curso,
            cuatri : cuatri
        } 
    }).exec(function(error, articulo){
        if(error) {
            console.log("Error al buscar con get");
            response.send("Error al buscar");
        }
        response.send(articulo);
    })
}

exports.getTienda = function (request, response) {

    Tienda.find().exec(function(error,tienda) {
        if(error){
            console.log("Error en get");
            response.send("Error al consultar")
        }
        response.send(tienda);
    });
}

exports.getVerificar = function (request, response) {

    let idUsuario = String(request.params.idUsuario);

    axios  
        .get('http://localhost:3010/usuario/mostrarUsuario'+`/${idUsuario}`)
        .then(res => {
            let respuesta = res.data.rol;
            if(respuesta=="administrador"){
                response.json("true");
            } else{
                response.json("false");
            }

           // response.json(respuesta);
        })
        .catch(error => {
            console.log(error);
        })
        
}

exports.postTienda = function (request, response) {

    let ID = request.body.id;
        let asignatura = request.body.asignatura;
        let curso = request.body.curso;
        let cuatri = request.body.cuatri;
        let profesor = request.body.profesor;
        let departamento = request.body.departamento;
        let idioma = request.body.idioma;
        let tipo = request.body.tipo;
        let autor = request.body.autor;
        let cantidad = request.body.cantidad;
        let precio = request.body.precio;

        /*if(cantidad == null){
            response.json({status: "Debe haber cantidad"});

        }else{*/

        Tienda.create({
            ID: ID,
            asignatura: asignatura,
            curso_academico: {
                curso: curso,
                cuatri: cuatri
            },
            profesorado: {

                profesor: profesor,
                departamento: departamento

            },
            idioma: idioma,
            tipo: tipo,
            autor: autor,
            cantidad : cantidad,
            precio : precio
        },
        function(error){
            if(error){
                console.log("Error al crear el articulo");
            }else{
            response.json({ status: "Articulo creado"});
            }
        });
    
}

exports.putArticuloComprado = function (request, response) {


    let id = String(request.params._id);
    let cantidad = request.query.cantidad;

    
    Tienda.findByIdAndUpdate(id, {
        $set: {
            cantidad : cantidad
        }
        },
     function(error){
        if(error){
        console.log("Error al actualizar");
        }
    });

    response.json({ status: "Articulo actualizado"});

}



exports.putArticulo = function (request, response) {


    let id = String(request.params._id);
    let asignatura = request.body.asignatura;
    let curso = request.body.curso;
    let cuatri = request.body.cuatri;
    let profesor = request.body.profesor;
    let departamento = request.body.departamento;
    let idioma = request.body.idioma;
    let tipo = request.body.tipo;
    let autor = request.body.autor;
    let cantidad = request.body.cantidad;
    let precio = request.body.precio;

    
    Tienda.findByIdAndUpdate(id, {
        $set: {
            asignatura: asignatura,
            "curso_academico.curso": curso,
            "curso_academico.cuatri": cuatri,
            "profesorado.profesor": profesor,
            "profesorado.departamento": departamento,
            idioma: idioma,
            tipo: tipo,
            autor: autor,
            cantidad : cantidad,
            precio : precio}
        },
     function(error){
        if(error){
        console.log("Error al actualizar");
        }
    });

    response.json({ status: "Articulo actualizado"});

}

exports.deleteArticulo = function (request, response) {

    let id = String(request.params._id);

        Tienda.findByIdAndDelete(
            {'_id': id},
            function(error){
                if(error){
                console.log("Error al borrar");
                }
            }
        );
        response.json({ status: "Articulo borrado"});
}