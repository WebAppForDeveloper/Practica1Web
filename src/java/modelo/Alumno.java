/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.Date;



/**
 *
 * @author javs
 */
public class Alumno {
    
    private long matricula;
    private String nombre;
    private String paternoAlumno;
    private String maternoAlumno;
    private String fechaNacimiento;
    private String calle;
    private String colonia;
    private int numero;
    private String codigoPostal;
    private String sexo;
    private String email;

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }
    private  int carrera;
    
    
    public Alumno() {
    }
    

    public long getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaternoAlumno() {
        return paternoAlumno;
    }

    public String getMaternoAlumno() {
        return maternoAlumno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCalle() {
        return calle;
    }

    public String getColonia() {
        return colonia;
    }

    public int getNumero() {
        return numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEmail() {
        return email;
    }

    
//  End Getters

    

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPaternoAlumno(String paternoAlumno) {
        this.paternoAlumno = paternoAlumno;
    }

    public void setMaternoAlumno(String maternoAlumno) {
        this.maternoAlumno = maternoAlumno;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Alumno{" + "matricula=" + matricula + ", nombre=" + nombre + ", paternoAlumno=" + paternoAlumno + ", maternoAlumno=" + maternoAlumno + ", fechaNacimineto=" + fechaNacimiento + ", calle=" + calle + ", colonia=" + colonia + ", numero=" + numero + ", codigoPostal=" + codigoPostal + ", sexo=" + sexo + ", email=" + email + '}';
    }

   
    
}
