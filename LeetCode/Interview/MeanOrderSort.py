#Return an array of integers sorted in meandering order
#[1st largest, 1st smallest, second largest, second smallest....]

def meanOrderSort(theArray):
	sortedArraySmallToLargest = sorted(theArray)
	outputArray = []
	startIndex = 0
	lastIndex = len(sortedArraySmallToLargest)-1
	while startIndex<lastIndex:
		outputArray.append(sortedArraySmallToLargest[lastIndex]) # largest
		outputArray.append(sortedArraySmallToLargest[startIndex]) # Second
		lastIndex-=1
		startIndex+=1
	if startIndex==lastIndex:
		outputArray.append(sortedArraySmallToLargest[lastIndex])
	return outputArray

if __name__=="__main__":
	print("input your array:")
	theArray = [int(i) for i in input().split()]
	print("input array is: ")
	print(theArray)
	sortedArray = meanOrderSort(theArray);
	print("sorted array is: ")
	print(sortedArray)