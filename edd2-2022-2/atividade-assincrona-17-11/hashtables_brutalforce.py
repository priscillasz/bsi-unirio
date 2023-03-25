# Given an array of integer nums and an integer target, return indices of the two numbers that they add up to target.

# solução
# 1) loop para cada par de itens na lista
# 2) verificar se alguma das somas dos pares de itens é igual a soma do target

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[j] == target - nums[i]:
                    return [i, j]