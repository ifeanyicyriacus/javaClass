def collectScores(scoreSheet:list, numberOfStudent:int, numberOfSubject:int) -> None:
    for studentIndex in range(numberOfStudent):
        temp_list = []
        for subjectIndex in range(numberOfSubject):
            score = float(input(f"Entering score for student {studentIndex + 1}: \nEnter score for subject {subjectIndex + 1}: \n"))
            temp_list.append(score)
            print("Saving >>>>>>>>>>>>>>>>>>>>>>>>\nSaved Succesfully");
        scoreSheet.insert(studentIndex, temp_list)
    
def displayTheScoreSheet(scoreSheet:list, numberOfSubject:int) -> str:
    addTotalToSheet(scoreSheet, numberOfSubject)
    addAverageToSheet(scoreSheet, numberOfSubject)
    addPositionToSheet(scoreSheet, numberOfSubject)
    
    output = divider("=")
    output += f"\n{'STUDENT':<10}"
    for index in range(numberOfSubject):
        output += f"{'SUB' + str(index+1):>5}"
    
    output += f"{'TOT':>5}  {'AVE':>5}  {'POS':>5}\n"
    output += divider("=")
    
    for studentIndex in range(len(scoreSheet)):
        output += f"\n {'Student' + str(studentIndex + 1):<10}"
        for subjectIndex in range(numberOfSubject+1):
            output += f"{scoreSheet[studentIndex][subjectIndex]:>5.0f}"
            
        length = len(scoreSheet[studentIndex])
        output += f"  {scoreSheet[studentIndex][length - 2]:>5.2f}  "
        output += f"{scoreSheet[studentIndex][length - 1]:>5.0f}  "
        output += "\n"
        
    output += divider("=")
    output += divider("=")
    return output;
        

def addTotalToSheet(scoreSheet:list, numberOfSubject:int) -> None:
    totalCol = numberOfSubject
    for studentScores in scoreSheet:
        total = getSumOfList(studentScores, 0, numberOfSubject)
        studentScores.insert(totalCol, total)

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

def addPositionToSheet(scoreSheet:list, numberOfSubject:int) -> None:
    positionCol = numberOfSubject + 2
    averageCol = numberOfSubject + 1
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
        result += f"The total score is: {totalSubjectScore:>.0f}\n"
        result += f"Average Score is: {totalSubjectScore:>.0f}\n"
        result += f"Number of passes: {numberThatPasses}\n"
        result += f"Number of fails: {numberThatFails}\n\n"
    return result
    

def getIndexOfHighest(numlist:list) -> int:
    listLength = len(numlist)
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
    listLength = len(numlist)
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
    
    overallHighestInfo = overallHighest(scoreSheet, numberOfSubject)
    overallHighestScoreStudent = int(overallHighestInfo[0]) + 1
    overallHighestScoreSubject = int(overallHighestInfo[1]) + 1
    overallHighestScore = overallHighestInfo[2]
    
    overallLowestInfo = overallLowest(scoreSheet, numberOfSubject)
    overallLowestScoreStudent = int(overallLowestInfo[0]) + 1
    overallLowestScoreSubject = int(overallLowestInfo[1]) + 1
    overallLowestScore = overallLowestInfo[2]
    
    totalColumn = numberOfSubject
    bestStudentIndex = getBestStudentIndex(scoreSheet, totalColumn)
    bestStudentTotal = scoreSheet[bestStudentIndex][totalColumn]
    worstStudentIndex = getWorstStudentIndex(scoreSheet, totalColumn)
    worstStudentTotal = scoreSheet[worstStudentIndex][totalColumn]
    totalScore = getClassTotalScore(scoreSheet, totalColumn)
    averageScore = getClassAverageScore(scoreSheet, totalColumn)
    
    result = f"The hardest subject is Subject {hardestSubjectIndex + 1} with {hardestSubjectFails} failures\n"
    result += f"The easiest subject is Subject {easiestSubjectIndex + 1} with {easiestSubjectPasses} passes\n"
    result += f"The overall Highest score is scored by student {overallHighestScoreStudent} in subject {overallHighestScoreSubject} scoring {overallHighestScore:>.0f}\n"
    result += f"The overall Lowest score is scored by student {overallLowestScoreStudent} in subject {overallLowestScoreSubject} scoring {overallLowestScore:>.0f}\n"
    
    result += divider("=")
    result += "\n"
    result += "CLASS SUMMARY\n"
    result += divider("=")
    result += f"Best Graduating Student is: Student {(bestStudentIndex+1)} scoring {bestStudentTotal:>.0f}\n"
    result += divider("=")
    result += "\n"
    result += divider("!")
    result += f"Worst Graduating Student is: Student {(worstStudentIndex+1)} scoring {worstStudentTotal:>.0f}\n"
    result += divider("!")
    result += "\n"
    result += divider("=")
    result += f"Class total score is: {totalScore:>.0f}\n"
    result += f"Class average score is: {averageScore:>.2f}\n"
    result += divider("=")
    return result;
    
def overallHighest(scoresheet, numberOfSubject) -> list:
    overallHighestRow = 0
    overallHighestCol = 0
    result = []
    overallHighest = scoresheet[overallHighestRow][overallHighestCol]
    for row in range(len(scoresheet)):
        for col in range(numberOfSubject):
            if overallHighest < scoresheet[row][col]:
                result.insert(0, row)
                result.insert(1, col)
                overallHighest = scoresheet[row][col]
                result.insert(2, overallHighest)
    return result

def overallLowest(scoresheet, numberOfSubject) -> list:
    overallLowestRow = 0
    overallLowestCol = 0
    result = []
    overallLowest = scoresheet[overallLowestRow][overallLowestCol]
    for row in range(len(scoresheet)):
        for col in range(numberOfSubject):
            if overallLowest > scoresheet[row][col]:
                result.insert(0, row)
                result.insert(1, col)
                overallLowest = scoresheet[row][col]
                result.insert(2, overallLowest)
    return result
    
def flipTable(table:list, row:int, col:int) -> list:
    flippedTable = []
    hasGeneratedRequiredCol = False
    for rowIndex in range(row):
        for colIndex in range(col):
            if hasGeneratedRequiredCol == False:
                flippedTable.insert(colIndex, [table[rowIndex][colIndex]])
            else:
                flippedTable[colIndex].append(table[rowIndex][colIndex])
        hasGeneratedRequiredCol = True 
    return flippedTable


def getHardestSubject(scoreSheet:list, numberOfSubject:int) -> int:
    passes = subjectToPassList(scoreSheet, numberOfSubject)
    return getIndexOfLowest(passes)

def getEasiestSubject(scoreSheet:list, numberOfSubject:int) -> int:
    passes = subjectToPassList(scoreSheet, numberOfSubject)
    return getIndexOfHighest(passes)
    
def subjectToPassList(scoreSheet:list, numberOfSubject:int) -> list:
    numberOfStudent = len(scoreSheet)
    flippedTable = flipTable(scoreSheet, numberOfStudent, numberOfSubject)
    passes = []
    index = 0
    for subjectScores in flippedTable:
        passes.insert(index, getNumbersThatPassed(subjectScores, 50))
        index += 1
    return passes
    
def getBestStudentIndex(scoreSheet:list, colIndex:int) -> int:
    totalsColumn = pluckDoubleColumn(scoreSheet, colIndex)
    return getIndexOfHighest(totalsColumn)
    
def getWorstStudentIndex(scoreSheet:list, colIndex:int) -> int:
    totalsColumn = pluckDoubleColumn(scoreSheet, colIndex)
    return getIndexOfLowest(totalsColumn)

def getClassTotalScore(scoreSheet:list, colIndex:int) -> float:
    totalsColumn = pluckDoubleColumn(scoreSheet, colIndex)
    return getSumOfList(totalsColumn, 0, len(totalsColumn))
    
def getClassAverageScore(scoreSheet:list, colIndex:int) -> float:
    averageColumn = pluckDoubleColumn(scoreSheet, colIndex)
    return getAverageOf(averageColumn, 0, len(averageColumn))
    
def divider(character:str) -> str:
    return f"{character * 50}\n"

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


