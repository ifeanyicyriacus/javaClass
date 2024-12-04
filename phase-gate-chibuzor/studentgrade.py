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
        scoreSheet.insert(studentIndex).append(temp_list)
        
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
        studentScores.insert(studentIndex).append(total)
             
def getSumOfList(num_list, ) -> float:
    
        
