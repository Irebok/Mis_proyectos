import { Injectable, NgModule } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Articulo } from '../models/articulos';
import { Usuario } from '../models/usuarios';
import { NgForm, NgModel } from '@angular/forms';


@Injectable({
    providedIn: 'root'
})

export class ArticuloTienda {
    
    URL = 'http://localhost:3000/tienda/mostrar';
    URL4 = 'http://localhost:3000/tienda/buscar';
    URL5 = 'http://localhost:3000/tienda/buscarId';
    URL1 = 'http://localhost:3000/tienda/crear';
    URL2 = 'http://localhost:3000/tienda/eliminar';
    URL3 = 'http://localhost:3000/tienda/actualizar';
    URL_USUARIO = 'http://localhost:3000/tienda/verificar';

    recogeDatos: Articulo = {
        _id: '',
        ID: 0,
        asignatura: '',
        curso_academico: {
            curso: '',
            cuatri: ''
        },
        profesorado: {
            profesor: '',
            departamento: ''
        },

        autor: '',
        cantidad: 0,
        precio: 0,
        
    };

    recogeBusqueda: Articulo = {
        _id: '',
        ID: 0,
        asignatura: '',
        curso_academico: {
            curso: '',
            cuatri: ''
        },
        profesorado: {
            profesor: '',
            departamento: ''
        },

        autor: '',
        cantidad: 0,
        precio: 0,
    }

    recogeUsuario: Usuario = {
        ID_usuario: 0
    }

    articulo: Articulo[] = [];



    constructor(private http: HttpClient) {}

    getTienda() {

        return this.http.get<Articulo[]>(this.URL);
        
    }

    getTiendaPorCurso(curso : String, cuatri : String) {

        return this.http.get<Articulo[]>(this.URL4+`?curso=${curso}&cuatri=${cuatri}`);
    }

    getTiendaPorId(id : string) {

        return this.http.get<Articulo[]>(`${this.URL5}/${id}`);
    }


    crearArticulo(articulo : Articulo) {

        console.log(articulo);

        return this.http.post(this.URL1, articulo);
    }

    eliminarArticulo(_id: String) {

        return this.http.delete(this.URL2+`/${_id}`);

    }

    editarArticulo(articulo: Articulo) {

        return this.http.put(this.URL3+`/${articulo._id}`, articulo);
    }

    getUsuario(ID_usuario: Number){
        
        return this.http.get(this.URL_USUARIO + `/${ID_usuario}`);
    }


}