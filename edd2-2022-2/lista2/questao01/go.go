package main
import fmt

func main() {  // O(1)  só temos atribuição de variavel e resultados.
	fmt.Print(Insira um numero )
  var n int
  fmt.Scanln(&n)
  
  
  if(n%2==0){
      fmt.Println(n,é par.)
  }
  else{
      fmt.Println(n,é impar.)
  }
}