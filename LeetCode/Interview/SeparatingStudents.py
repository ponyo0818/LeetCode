# return the minimum number ofmoves necessary to achieve an optimal configuration
# [0,0,0,1,1,1] group the same value integer together

#[1,0,1,0,1,0]
#[0,0,0,1,1,1]

# (Array, sortedArray, 1, 0)
def calculateDistance(array1, array2, value1, value2):
	value1ToValue2 = []
	value2ToValue1 = []
	result = 0
	for i in range(len(array1)):
		if array1[i] == value1 and array2[i] == value2:
			value1ToValue2.append(i) #append the position that 1 change to 0 [0,2]
		if array1[i] == value2 and array2[i] == value1:
			value2ToValue1.append(i) #append the position that 0 change to 1 [3,5]
	for i in range(len(value2ToValue1)):
		result+=abs(value1ToValue2[i]-value2ToValue1[i])
	return result

def minMoves(theArray):
	sortedArray = sorted(theArray) #0->1
	result = calculateDistance(theArray, sortedArray, 1, 0) #1->0 0->1
	sortedArray.reverse()# 1->0
	result = min(result, calculateDistance(theArray, sortedArray, 0, 1)) #0->1 1->0
	return result

if __name__=="__main__":
	print("input your array:")
	theArray = [int(i) for i in input().split()]
	print("input array is: ")
	print(theArray)
	theOutput = minMoves(theArray);
	print("output is: ")
	print(theOutput)