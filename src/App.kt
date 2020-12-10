
    /* ================ SAMPLE DATASET ==================
    *  SIKAP               PERBUATAN     AKIBAT
    *  Individualisme      Negatif       TidakDisukaiTeman
    *  Sosialisme          Positif       DisukaiTeman
    *  Sosialisme          Negatif       DisukaiTeman
    *  Sosialisme          Negatif       TidakDisukaiTeman
    *  Sosialisme          Negatif       TidakDisukaiTeman
    *  Individualisme      Positif       DisukaiTeman
    *  Individualisme      Negatif       DisukaiTeman
    *  Individualisme      Negatif       TidakDisukaiTeman
    *  Individualisme      Negatif       TidakDisukaiTeman
    *  Sosialisme          Positif       DisukaiTeman
    *  Sosialisme          Positif       DisukaiTeman
    *  Sosialisme          Positif       DisukaiTeman
    *  Sosialisme          Positif       DisukaiTeman
    *  Sosialisme          Positif       DisukaiTeman
    *  Sosialisme          Positif       DisukaiTeman
    *  Sosialisme          Positif       DisukaiTeman
    *  Individualisme      Negatif       TidakDisukaiTeman
    **/

    var P_Disukai_Teman: Double = 0.0
    var P_Tidak_Disukai_Teman: Double = 0.0
    var P_Individualisme_Disukai_Teman: Double = 0.0
    var P_Sosialisme_Disukai_Teman: Double = 0.0
    var P_Individualisme_Tidak_Disukai_Teman: Double = 0.0
    var P_Sosialisme_Tidak_Disukai_Teman: Double = 0.0
    var P_Positif_Disukai_Teman: Double = 0.0
    var P_Negatif_Disukai_Teman: Double = 0.0
    var P_Positif_Tidak_Disukai_Teman: Double = 0.0
    var P_Negatif_Tidak_Disukai_Teman: Double = 0.0

fun main() {
    val Sikap: Array<String> = arrayOf(
            "Individualisme", "Sosialisme", "Sosialisme", "Sosialisme", "Sosialisme",
            "Individualisme", "Individualisme", "Individualisme", "Individualisme", "Sosialisme",
            "Sosialisme", "Sosialisme", "Sosialisme", "Sosialisme", "Sosialisme",
            "Sosialisme", "Individualisme")
    val Perbuatan: Array<String> = arrayOf(
            "Negatif", "Positif", "Negatif", "Negatif", "Negatif",
            "Positif", "Negatif", "Negatif", "Negatif", "Positif",
            "Positif", "Positif", "Positif", "Positif", "Positif", "Positif", "Negatif")
    val Akibat: Array<String> = arrayOf(
            "TidakDisukaiTeman", "DisukaiTeman", "DisukaiTeman", "TidakDisukaiTeman", "TidakDisukaiTeman",
            "DisukaiTeman", "DisukaiTeman", "TidakDisukaiTeman", "TidakDisukaiTeman", "DisukaiTeman",
            "DisukaiTeman", "DisukaiTeman", "DisukaiTeman", "DisukaiTeman", "DisukaiTeman", "DisukaiTeman", "TidakDisukaiTeman")

    val length = Sikap.size - 1

    println("======= DATA TRAINING =======")
    println("[SIKAP]\t\t\t[PERBUATAN]\t\t[AKIBAT]")
    for (value in 0..length) {
        println("${Sikap[value]}\t\t${Perbuatan[value]}\t\t${Akibat[value]}")
    }


    println("\n\n======= JUMLAH DAN PROBABILITAS AKIBAT =======")
    val Jumlah_Disukai_Teman = hitungJumlah(Akibat, "DisukaiTeman")
    val Jumlah_Tidak_Disukai_Teman = hitungJumlah(Akibat, "TidakDisukaiTeman")
    P_Disukai_Teman = probabilitasAkibat(Jumlah_Disukai_Teman, Jumlah_Tidak_Disukai_Teman)
    P_Tidak_Disukai_Teman = probabilitasAkibat(Jumlah_Tidak_Disukai_Teman, Jumlah_Disukai_Teman)

    println("JUMLAH Disukai Teman         : $Jumlah_Disukai_Teman")
    println("JUMLAH Tidak Disukai Teman   : $Jumlah_Tidak_Disukai_Teman\n")
    println("PROBABABILITAS Disukai Teman : $P_Disukai_Teman")
    println("PROBABABILITAS Tidak Disukai Teman : $P_Tidak_Disukai_Teman\n\n")




    println("======= JUMLAH DAN PROBABILITAS SIKAP =======")
    val Jumlah_Individualisme_Disukai_Teman = counts(Sikap, Akibat, "Individualisme", "DisukaiTeman")
    val Jumlah_Sosialisme_Disukai_Teman     = counts(Sikap, Akibat, "Sosialisme", "DisukaiTeman")
    val Jumlah_Individualisme_Tidak_Disukai_Teman = counts(Sikap, Akibat, "Individualisme", "TidakDisukaiTeman")
    val Jumlah_Sosialisme_Tidak_Disukai_Teman     = counts(Sikap, Akibat, "Sosialisme", "TidakDisukaiTeman")

    P_Individualisme_Disukai_Teman       = pAttribute(Jumlah_Individualisme_Disukai_Teman, Jumlah_Disukai_Teman)
    P_Sosialisme_Disukai_Teman           = pAttribute(Jumlah_Sosialisme_Disukai_Teman, Jumlah_Disukai_Teman)
    P_Individualisme_Tidak_Disukai_Teman = pAttribute(Jumlah_Individualisme_Tidak_Disukai_Teman, Jumlah_Tidak_Disukai_Teman)
    P_Sosialisme_Tidak_Disukai_Teman     = pAttribute(Jumlah_Sosialisme_Tidak_Disukai_Teman, Jumlah_Tidak_Disukai_Teman)

    println("JUMLAH Individualisme Disukai Teman       : $Jumlah_Individualisme_Disukai_Teman")
    println("JUMLAH Sosialisme Disukai Teman           : $Jumlah_Sosialisme_Disukai_Teman")
    println("JUMLAH Individualisme Tidak Disukai Teman       : $Jumlah_Individualisme_Tidak_Disukai_Teman")
    println("JUMLAH Sosialisme Tidak Disukai Teman           : $Jumlah_Sosialisme_Tidak_Disukai_Teman\n")

    println("PROBABABILITAS Individualisme Disukai Teman       : $P_Individualisme_Disukai_Teman")
    println("PROBABABILITAS Sosialisme Disukai Teman           : $P_Sosialisme_Disukai_Teman")
    println("PROBABABILITAS Individualisme Tidak Disukai Teman : $P_Individualisme_Tidak_Disukai_Teman")
    println("PROBABABILITAS Sosialisme Tidak Disukai Teman     : $P_Sosialisme_Tidak_Disukai_Teman\n\n")





    println("======= JUMLAH DAN PROBABILITAS PERBUATAN =======")
    val Jumlah_Positif_Disukai_Teman       = counts(Perbuatan, Akibat, "Positif", "DisukaiTeman")
    val Jumlah_Negatif_Disukai_Teman       = counts(Perbuatan, Akibat, "Negatif", "DisukaiTeman")
    val Jumlah_Positif_Tidak_Disukai_Teman = counts(Perbuatan, Akibat, "Positif", "TidakDisukaiTeman")
    val Jumlah_Negatif_Tidak_Disukai_Teman = counts(Perbuatan, Akibat, "Negatif", "TidakDisukaiTeman")

    P_Positif_Disukai_Teman = pAttribute(Jumlah_Positif_Disukai_Teman, Jumlah_Disukai_Teman)
    P_Negatif_Disukai_Teman = pAttribute(Jumlah_Negatif_Disukai_Teman, Jumlah_Disukai_Teman)
    P_Positif_Tidak_Disukai_Teman = pAttribute(Jumlah_Positif_Tidak_Disukai_Teman, Jumlah_Tidak_Disukai_Teman)
    P_Negatif_Tidak_Disukai_Teman = pAttribute(Jumlah_Negatif_Tidak_Disukai_Teman, Jumlah_Tidak_Disukai_Teman)

    println("JUMLAH Positif Disukai Teman       : $Jumlah_Positif_Disukai_Teman")
    println("JUMLAH Negatif Disukai Teman       : $Jumlah_Negatif_Disukai_Teman")
    println("JUMLAH Positif Tidak Disukai Teman : $Jumlah_Positif_Tidak_Disukai_Teman")
    println("JUMLAH Negatif Tidak Disukai Teman : $Jumlah_Negatif_Tidak_Disukai_Teman\n")

    println("PROBABABILITAS Positif Disukai Teman       : $P_Positif_Disukai_Teman")
    println("PROBABABILITAS Negatif Disukai Teman       : $P_Negatif_Disukai_Teman")
    println("PROBABABILITAS Positif Tidak Disukai Teman : $P_Positif_Tidak_Disukai_Teman")
    println("PROBABABILITAS Negatif Tidak Disukai Teman : $P_Negatif_Tidak_Disukai_Teman\n\n")

    println("DATA TEST")
    val datatestSikap    = listOf("Individualisme", "Individualisme", "Sosialisme", "Sosialisme")
    val datatestPerbuatan = listOf("Positif", "Negatif", "Positif", "Negatif")
    val lengthDataTest = datatestSikap.size - 1
    for (value in 0..lengthDataTest) {
        println("-------------------------------------")
        println(datatestSikap[value]  + " & " + datatestPerbuatan[value])
        val result = prediksiNaiveBayes(datatestSikap[value], datatestPerbuatan[value])
        println(result)
        println("-------------------------------------\n")
    }
}

fun prediksiNaiveBayes(sikap1: String, perbuatan1: String): String {
    var result_disukai_teman = 0.0
    var result_tidak_result_disukai_teman = 0.0
    if ((sikap1 == "Individualisme") && (perbuatan1 == "Positif")) {
        result_disukai_teman = P_Individualisme_Disukai_Teman * P_Positif_Disukai_Teman * P_Disukai_Teman
        result_tidak_result_disukai_teman = P_Individualisme_Tidak_Disukai_Teman * P_Positif_Tidak_Disukai_Teman * P_Tidak_Disukai_Teman
    } else if((sikap1 == "Individualisme") && (perbuatan1 == "Negatif")) {
        result_disukai_teman = P_Individualisme_Disukai_Teman * P_Negatif_Disukai_Teman * P_Disukai_Teman
        result_tidak_result_disukai_teman = P_Individualisme_Tidak_Disukai_Teman * P_Negatif_Tidak_Disukai_Teman * P_Tidak_Disukai_Teman
    } else if((sikap1 == "Sosialisme") && (perbuatan1 == "Positif")) {
        result_disukai_teman = P_Sosialisme_Disukai_Teman * P_Positif_Disukai_Teman * P_Disukai_Teman
        result_tidak_result_disukai_teman = P_Sosialisme_Tidak_Disukai_Teman * P_Positif_Tidak_Disukai_Teman * P_Tidak_Disukai_Teman
    } else if((sikap1 == "Sosialisme") && (perbuatan1 == "Negatif")) {
        result_disukai_teman = P_Sosialisme_Disukai_Teman * P_Negatif_Disukai_Teman * P_Disukai_Teman
        result_tidak_result_disukai_teman = P_Sosialisme_Tidak_Disukai_Teman * P_Negatif_Tidak_Disukai_Teman * P_Tidak_Disukai_Teman
    }else {
        println("NOT FOUND")
    }
    println("HASIL DISUKAI TEMAN       = $result_disukai_teman")
    println("hasil TIDAK DISUKAI TEMAN = $result_tidak_result_disukai_teman")
    return if (result_disukai_teman > result_tidak_result_disukai_teman) {
        "ANDA DISUKAI TEMAN"
    } else {
        "ANDA TIDAK DISUKAI TEMAN"
    }
}

fun pAttribute(jumlahIndividualismeDisukaiTeman: Int, jumlahDisukaiTeman: Int): Double {
    return jumlahIndividualismeDisukaiTeman.toDouble() / jumlahDisukaiTeman.toDouble()
}
fun counts(cause: Array<String>, effect: Array<String>, valueCause: String, valueEffect: String): Int {
    var hitung = 0
    val length = cause.size - 1
    for (value in 0..length) {
        if ((cause[value] == valueCause) && (effect[value] == valueEffect)) {
          hitung++
        }
    }
    return hitung
}
fun hitungJumlah(akibat: Array<String>, s: String): Int {
    val length = akibat.size - 1
    var hitung= 0
    for (value in 0..length) {
      if (akibat[value] == s) {
          hitung++
      }
    }
    return hitung
}
fun probabilitasAkibat(Jumlah_Disukai_Teman: Int, Jumlah_Tidak_Disukai_Teman: Int): Double {
    return Jumlah_Disukai_Teman.toDouble() / (Jumlah_Disukai_Teman.toDouble() + Jumlah_Tidak_Disukai_Teman.toDouble())
}