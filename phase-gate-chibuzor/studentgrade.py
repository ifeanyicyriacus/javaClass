NUMBER_OF_COLUMN_NEEDED = 3
print("Lagbaja Schools")

numberOfStudent = int(input("Enter number of students: "))
numberOfSubject = int(input("Enter number of subjects: "))

print("Saving >>>>>>>>>>>>>>>>>>>>>>>>\nSaved Succesfully")

scoreSheet = []
collectScores(scoreSheet, numberOfStudent, numberOfSubject)
print()
print(displayTheScoreSheet(scoreSheet, numberOfSubject))
print(displaySubjectSummary(scoreSheet, numberOfSubject))
print(displayClassSummary(scoreSheet, numberOfSubject, numberOfStudent))

def collectScores(scoreSheet:list, numberOfStudent:int, numberOfSubject:int) -> None:
    for studentIndex in range(numberOfStudent):
        temp_list = []
        for subjectIndex in range(numberOfSubject):
            print(f"Entering score for student {studentIndex + 1}: \n");
            print(f"Enter score for subject {subjectIndex + 1}: \n");
            score = float(input())
            temp_list.append(score)
            print("Saving >>>>>>>>>>>>>>>>>>>>>>>>\nSaved Succesfully");
        scoreSheet.insert(studentIndex, temp_list)
        
def displayTheScoreSheet(scoreSheet, numberOfSubject) -> str:
    addTotalToSheet(scoreSheet, numberOfSubject)
    addAverageToSheet(scoreSheet, numberOfSubject)
    addPositionToSheet(scoreSheet)
    
    output = divider("=")
    output += f"{'STUDENT':>10}"
    for index in range(numberOfSubject):
        output += f"{'SUB' + index:>5}"
    
    output += f"{'TOT':>5}  {'AVE':>5}  {'POS':>5}\n"
    output += divider("=")
    
    for studentIndex in range(len(scoreSheet)):
        output += f"Student {studentIndex + 1:>10}"
        for subjectIndex in range(numberOfSubject):
            output += f"{scoreSheet[studentIndex][subjectIndex]:>5.0f}"
            
        length = len(scoreSheet[studentIndex])
        output += f"{scoreSheet[studentIndex][length - 2]:>5.2f}  "
	    output += f"{scoreSheet[studentIndex][length - 1]:>5.2f}  "
        output += "\n"
        
    output += divider("=")
    output += divider("=")
    return output;
        

def addTotalToSheet(scoreSheet:list, numberOfSubject:int) -> None:
    totalCol = numberOfSubject
    for studentScores in scoreSheet:
        total = getSumOfList(studentScores, 0, numberOfSubject)
        studentScores.insert(studentIndex, total)
             
def getSumOfList(num_list:list, start:int, stop:int) -> float:
    return sum(num_list[start: stop])

def addAverageToSheet(scoreSheet:list, numberOfSubject:int) -> None:
    averageCol = numberOfSubject + 1
    for studentScores in scoreSheet:
        average = getAverageOf(studentScores, 0, numberOfSubject)
        studentScores.insert(averageCol, average)
               
def getAverageOf(num_list:list, start:int, stop:int) -> float:
    noOfvalues = stop - start
    total = getSumOfList(num_list, start, stop)
    return total / float(noOfvalues)

def addPositionToSheet(scoreSheet:list) -> None:
    positionCol = len(scoreSheet[0]) - 1
    averageCol = len(scoreSheet[0]) - 2
    averages = pluckDoubleColumn(scoreSheet, averageCol)

    posRank = getRanks(averages)
    index = 0
    for studentScores in scoreSheet:
        studentScores.insert(positionCol, posRank[index])
        index += 1
        
def getRanks(numbers:list) -> int:
    sortedNumbers = numbers
    sortedNumbers.sort()
    rank = len(numbers)
    result = numbers
    for indexSorted in range(len(sortedNumbers)):
        for indexOriginal in range(len(numbers)):
            if sortedNumbers[indexSorted] == numbers[indexOriginal]:
                result[indexOriginal] = rank
                rank -= 1
    return result
    
def displaySubjectSummary(scoreSheet:list, numberOfSubject:int) -> str:
    result = "SUBJECT SUMMARY\n"
    PASS_MARK = 50
    
    for index in range(numberOfSubject):
        subjectScores = pluckDoubleColumn(scoreSheet, index)
        highestSubjectIndex = getIndexOfHighest(subjectScores)
        lowestSubjectIndex = getIndexOfLowest(subjectScores)
        totalSubjectScore = getSumOfList(subjectScores, 0, len(subjectScores))
        subjectAverage = getAverageOf(subjectScores, 0, len(subjectScores))
        numberThatPasses = getNumbersThatPassed(subjectScores, PASS_MARK)
        numberThatFails = len(subjectScores) - numberThatPasses
        highestSubjectScore = scoreSheet[highestSubjectIndex][index]
        lowestSubjectScore = scoreSheet[lowestSubjectIndex][index]

        result += f"Subject {index+1}\n"
        result += f"Highest scoring student is: Student {highestSubjectIndex + 1} scoring {highestSubjectScore:>.0f}\n"
        result += f"Lowest scoring student is: Student {lowestSubjectIndex + 1} scoring {lowestSubjectScore:>.0f}\n"
        result += f"The total score is: %.0f%n", totalSubjectScore
        result += f"Average Score is: {totalSubjectScore:>.0f}\n"
        result += f"Number of passes: {numberThatPasses}\n"
        result += f"Number of fails: {numberThatFails}\n\n"
    return result
    

def getIndexOfHighest(numlist:list) -> int:
    listLength = len(numList)
    sortedList = numlist
    sortedList.sort()
    highest = sortedList[listLength - 1]
    highestIndex = 0
    for index in range(listLength):
        if highest == numlist[index]:
            highestIndex = index
            break
    return highestIndex
    
def getIndexOfLowest(numlist:list) -> int:
    listLength = len(numList)
    sortedList = numlist
    sortedList.sort()
    lowest = sortedList[0]
    lowestIndex = 0
    for index in range(listLength):
        if lowest == numlist[index]:
            lowestIndex = index
            break
    return lowestIndex        
    
def getNumbersThatPassed(column:list, passMark:int) -> int:
    passCount = 0
    for value in column:
        if value >= passMark:
            passCount += 1
    return passCount
    
def pluckDoubleColumn(table:list, columnNumber:int) -> list:
    result = []
    for index in range(len(table)):
        result.insert(index, table[index][columnNumber])
    return result
    
def displayClassSummary(scoreSheet, numberOfSubject, numberOfStudent) -> str:
    hardestSubjectIndex = getHardestSubject(scoreSheet, numberOfSubject)
    easiestSubjectIndex = getEasiestSubject(scoreSheet, numberOfSubject)
    passes = subjectToPassList(scoreSheet, numberOfSubject)
    hardestSubjectFails = numberOfStudent - passes[hardestSubjectIndex]
    easiestSubjectPasses = passes[easiestSubjectIndex]
    
    overallHighest = overallHighest(scoreSheet, numberOfSubject)
    overallHighestScoreStudent = int(overallHighest[0]) + 1
    overallHighestScoreSubject = int(overallHighest[1]) + 1
    overallHighestScore = overallHighest[2]
    
    overallLowest = overallLowest(scoreSheet, numberOfSubject)
    overallLowestScoreStudent = int(overallLowest[0]) + 1
    overallLowestScoreSubject = int(overallLowest[1]) + 1
    overallLowestScore = overallLowest[2]
    
    totalColumn = numberOfSubject; 
    bestStudentIndex = getBestStudentIndex(scoreSheet, totalColumn);
    bestStudentTotal = scoreSheet[bestStudentIndex][totalColumn];
    worstStudentIndex = getWorstStudentIndex(scoreSheet, totalColumn);
    worstStudentTotal = scoreSheet[worstStudentIndex][totalColumn];
    totalScore = getClassTotalScore(scoreSheet, totalColumn);
    averageScore = getClassAverageScore(scoreSheet, totalColumn);
    
result = f"The hardest subject is Subject {} with {} failures%n", (hardestSubjectIndex + 1), hardestSubjectFails)
result += f"The easiest subject is Subject {} with {} passes%n", (easiestSubjectIndex + 1), easiestSubjectPasses);

result += f"The overall Highest score is scored by student %d in subject %d scoring %.0f%n", overallHighestScoreStudent, overallHighestScoreSubject, overallHighestScore);
result += f"The overall Lowest score is scored by student %d in subject %d scoring %.0f%n", overallLowestScoreStudent, overallLowestScoreSubject, overallLowestScore);












