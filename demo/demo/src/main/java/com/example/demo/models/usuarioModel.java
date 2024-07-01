package com.exammple.demo.models;

@Entity
//@Table(name = 'usuario')
public class UsuarioModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idUsuario;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private Date fechaNacimiento;


    public void setId(Long idUsuario){
            this.idUsuario = idUsuario;
    }
    
    public Long getId(){
        return idUsuario;
    }

    public void setNomnre(String nombre){
        this.nombre = nombre;
    }

    public Long getNombre(){
        return nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno){
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoPaterno(){
        return apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno){
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoMaterno(){
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setFechaNacimiento(Date fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaNacimiento(){
        return fechaNacimiento;
    }

}