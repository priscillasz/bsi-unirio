const bubbleSort = (arr: number[]): number[] => {
    const len = arr.length;

    for (let i = 0; i < len; i++) { //O(n)
        for (let j = 0; j < len; j++) { // O(n)
            if (arr[j] > arr[j + 1]) { 
                [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
            }
        }
    }

    return arr;
}
// O(n) * O(n) = O(n^2)

console.log(bubbleSort([7,3,9,2,1,5,13,2]))
