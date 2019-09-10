#Leetcode 134 Gas station similar
#return start point if there is a solution, otherwise return -1

def optimalPoint(magic, dist):
	if sum(magic)<sum(dist):
		return -1
	accumulate = [x-y for x,y in zip(magic,dist)]
	energy = accumulate[0]
	result = 0
	for i in range(1,len(accumulate)):
		if energy<0:
			result = i
			energy = 0
		energy+=accumulate[i]
	return result

if __name__=="__main__":
	print("input your array:")
	theArray = [int(i) for i in input().split()]
	numberOfStation = int(len(theArray)/2)
	magic = theArray[0:(numberOfStation)]
	dist = theArray[(numberOfStation):(numberOfStation*2)]
	print("magic is: ")
	print(magic)
	print("dist is: ")
	print(dist)
	result = optimalPoint(magic,dist)
	print("result is: ")
	print(result)