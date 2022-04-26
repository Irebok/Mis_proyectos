import { Component, OnInit } from '@angular/core';
import { ArticuloTienda } from 'src/app/services/articulos.servicio';
import { NgForm, NgModel } from '@angular/forms';
import { Usuario } from 'src/app/models/usuarios';
import { Observable } from 'rxjs';

@Component({
    selector: 'app-usuarios',
    templateUrl: './usuarios.component.html',
    styleUrls: ['./usuarios.component.css'],
    providers: [ArticuloTienda]
})
export class UsuariosComponent implements OnInit {
    esAdmin : boolean = false;

    constructor(public controlUsuario : ArticuloTienda) { }

    ngOnInit(): void {

    }

    comprobarUsuario(ID_usuario: Number) {

        this.controlUsuario.getUsuario(ID_usuario).subscribe(
            res => {
                
                
                if(res == "true"){
                    this.esAdmin = true;
                }else{
                    this.esAdmin = false;
                    alert("No eres un admin, largo de aquí");
                }
                
               // this.comprobarAdmin(res);
            },
            err=> console.error(err)
        );

    }

    comprobarAdmin(res: Object) {
        
        console.log(res);
        
    }
    

}