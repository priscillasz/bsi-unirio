// Swift - O(log n)
func binarySearch(key: Int, imin: Int, imax: Int) {

    //Encontra os valores no meio do index - O (1)
    var midIndex : Double = round(Double((imin + imax) / 2))
    var midNumber = numberList[Int(midIndex)]

    // Usa recursão para reduzir as possibilidades de busca - Busca binária
    // Logo, as possibilidades são O(log n)
    if (midNumber > key ) {
        binarySearch(key: key, imin: imin, imax: Int(midIndex) - 1)
    }
    else if (midNumber < key ) {
        binarySearch(key: key, imin: Int(midIndex) + 1, imax: imax)
    }
    else {
        let results = "value \(key) found.."
    }
}
// O(1) + O (log n) = O (log n)
