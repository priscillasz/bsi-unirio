<?php
# Retorna o elemento que se repete por um número ímpar de vezes na sequência.

# Complexidade do método: O(n^2)
# Há um loop externo que percorre a array e outro loop interno também percorrendo a array. Sendo n o tamanho percorrido pelo loop, a complexidade é O(n^2).
function getRepeticoesImpar(&$arr, $arr_size)
{
    $count = 0;
    for ($i = 0;
         $i < $arr_size; $i++)
    {
         
        for ($j = 0;
             $j < $arr_size; $j++)
        {
            if ($arr[$i] == $arr[$j])
                $count++;
        }
        if ($count % 2 != 0)
            return $arr[$i];
    }
    return -1;
}
 
//
$arr = array(2, 3, 5, 4, 5, 2,
             4, 3, 5, 2, 4, 4, 2);
$n = sizeof($arr);
 
// Chamada da função
echo(getRepeticoesImpar($arr, $n));

?>