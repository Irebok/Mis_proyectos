import { Component, OnInit } from '@angular/core';
import { ArticuloTienda } from 'src/app/services/articulos.servicio';
import { NgForm, NgModel } from '@angular/forms';
import { Articulo } from 'src/app/models/articulos';

@Component({
  selector: 'app-articulos',
  templateUrl: './articulos.component.html',
  styleUrls: ['./articulos.component.css'],
  providers: [ArticuloTienda]
})
export class ArticulosComponent implements OnInit {

  constructor(public articuloTienda : ArticuloTienda) { }

  ngOnInit(): void {
    
    this.getArticulos();

    }
    curso ="";
    cuatri = "";
    asignatura = "";

    /******************************Mostrar articulos*************************/ 
    getArticulos(){
      
      this.articuloTienda.getTienda().subscribe((
        res )=> {
          this.articuloTienda.articulo = res;
          },
        err => console.error(err) 
        
        )
    }

    getArticuloPorAno(curso : String, cuatri : String) {

      this.articuloTienda.getTiendaPorCurso(curso,cuatri).subscribe((
        res) => {
          this.articuloTienda.articulo = res;
          console.log(res);

        },
        err => console.error(err)
      )
    }

    getArticuloPorId(id : string) {

      this.articuloTienda.getTiendaPorId(id).subscribe((
        res) => {
          this.articuloTienda.articulo = res;
          console.log(res);

        },
        err => console.error(err)
      )
    }

    /************************Crear un articulo*********************/

    postArticulo(form : NgForm ){

      if((form.value.asignatura == "") || (form.value.asignatura == null)){
        alert("Falta el campo asignatura");
      }
      else if((form.value.curso == "") || (form.value.curso == null)){
        alert("Falta el campo curso");
      }
      else if((form.value.cuatri == "") || (form.value.cuatri == null)){
        alert("Falta el campo cuatri");
      }
      else if(!(form.value.idioma == "español") && !(form.value.idioma == "ingles") && !(form.value.idioma == "galego") && !(form.value.idioma == null) && !(form.value.idioma == "")) {
        alert("Valor no posible (español, ingles, galego)");
      }

      else if(!(form.value.tipo == "teoria") && !(form.value.tipo == "practica") && !(form.value.tipo == null) && !(form.value.tipo == "")) {
        alert("Valor no posible (teoria, practica)");
      }

      else if((form.value.cantidad == 0) || (form.value.cantidad == null)){
        alert("Falta el campo cantidad");
      }
      else if((form.value.precio == 0) || (form.value.precio == null)) {
        alert("Falta el campo precio");
      }
      
      else{
        
      if(form.value._id) {
        this.articuloTienda.editarArticulo(form.value).subscribe(
          res => {
            this.getArticulos();
            this.resetFormulario(form);

                        
          },
          err => console.error(err)
        )
        alert("Actualizado con exito");
        //location.reload();

      }else {

        

        this.articuloTienda.crearArticulo(form.value).subscribe(
          res => {
            this.getArticulos();
            this.resetFormulario(form);
            
          },
          err => console.error(err)
        )
        alert("Creado con exito");
        }
          
        
  
        //location.reload();

      }


    }

    /************************Eliminar articulo**********************/

    deleteArticulo(_id: string, form: NgForm) {

      if(confirm("Vas a eliminar un articulo, seguro?")){
        
        this.articuloTienda.eliminarArticulo(_id).subscribe((res) => { 
            this.getArticulos();
            this.resetFormulario(form);
            alert("Eliminado con exito");
          });
          
        }
        //location.reload();
  }

  putArticulo(articulo: Articulo) {

    this.articuloTienda.recogeDatos = articulo;
    //this.getArticulos();

  }


  resetFormulario(form?: NgForm) {
    if(form) {
      form.reset();
      //this.articuloTienda.recogeDatos = new Articulo();
    }
  }


}
