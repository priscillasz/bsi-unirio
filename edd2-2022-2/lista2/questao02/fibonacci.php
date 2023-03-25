<?php
// Programa para descobrir o número x da sequência fibonacci
// Complexidade: O(log n), pois calcular phi ^ n requer tempo logarítmico
function fib($n)
{
	$phi = (1 + sqrt(5)) / 2;
	return round(pow($phi, $n) / sqrt(5)); // O(log n)
}

$n = 9;
echo fib($n) ;
?>
