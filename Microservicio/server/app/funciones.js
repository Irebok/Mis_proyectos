var Tienda = require('./modelo/esquema');
var Controller = require ('./controller');
const { collection } = require('./modelo/esquema');

module.exports = function(app) {

    app.get('/tienda', Controller.getPrincipal);

    app.get('/tienda/mostrar', Controller.getTienda);

    app.get('/tienda/buscarId/:id', Controller.getID);

    app.get('/tienda/buscar', Controller.getArticulo);

    app.get('/tienda/verificar/:idUsuario', Controller.getVerificar);

    app.post('/tienda/crear', Controller.postTienda);

    app.put('/tienda/actualizarCantidad/:_id', Controller.putArticuloComprado);

    app.put('/tienda/actualizar/:_id', Controller.putArticulo);

    app.delete('/tienda/eliminar/:_id', Controller.deleteArticulo);

};