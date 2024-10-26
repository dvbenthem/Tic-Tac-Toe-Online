fun main() {
    // put your code here
    val letter = readln()

    for (i in 'a'..'z') {

        if (i == letter.first()){

            break
        }
        print(i)
    }
}