import java.util.*
import kotlin.random.Random.Default.nextInt

open class ArmaDeFuego() {
    open var nombre: String= ""
    open var municion: Int= 0
    open var municionARestar: Int=0
    open var tipoDeMunicion:String= ""
    open var danio: Int= 0
    open var radio: String= ""

    constructor(nombre:String, tipoDeMunicion:String, danio:Int, radio:String, municion:Int=100) : this() {
        this.nombre=nombre
        this.tipoDeMunicion=tipoDeMunicion
        this.danio=danio
        this.radio=radio
        this.municion=municion
    }
    open fun dispara(){
        println("El arma "+this.nombre+" ha disparado. Queda tras el disparo : "+this.municion+" balas")
    }
    open fun recarga(){
        this.municion=this.municion+1
        println("Recarga la munición, queda: "+this.municion)
    }
}

class Pistola() : ArmaDeFuego() {
    constructor(nombre:String, tipoDeMunicion:String, danio:Int, radio:String, municion:Int=100) : this() {
        this.nombre=nombre
        this.tipoDeMunicion=tipoDeMunicion
        this.danio=danio
        this.radio=radio
        this.municion=municion
    }
    override var municionARestar=1
    override fun dispara() {
        this.municion=this.municion-this.municionARestar
        super.dispara()
    }
}
class Rifle() : ArmaDeFuego() {
    constructor(nombre:String, tipoDeMunicion:String, danio:Int, radio:String, municion:Int=100) : this() {
        this.nombre=nombre
        this.tipoDeMunicion=tipoDeMunicion
        this.danio=danio
        this.radio=radio
        this.municion=municion
    }
    override var municionARestar=2
    override fun dispara() {
        this.municion=this.municion-this.municionARestar
        super.dispara()
    }
}
class Bazooka() : ArmaDeFuego() {
    constructor(nombre:String, tipoDeMunicion:String, danio:Int, radio:String, municion:Int=100) : this() {
        this.nombre=nombre
        this.tipoDeMunicion=tipoDeMunicion
        this.danio=danio
        this.radio=radio
        this.municion=municion
    }
    override var municionARestar=3
    override fun dispara() {
        this.municion=this.municion-this.municionARestar
        super.dispara()
    }
}
fun main(args: Array<String>) {
    var armas: ArrayList<ArmaDeFuego> = arrayListOf()
    var random = 0

    for(num in 0..5){
        random = (1..3).random()
        if(random==1){
            armas.add(Pistola("Pistola "+(num+1).toString(),"ligera",2,"pequeña"))
            armas.get(num).dispara()
        }
        else if(random==2){
            armas.add(Rifle("Rifle "+(num+1).toString(),"mediana",2,"pequeña"))
            armas.get(num).dispara()
        }
        else{
            armas.add(Bazooka("Bazooka "+(num+1).toString(),"grande",2,"amplío"))
            armas.get(num).dispara()
        }
    }
}