# Topic: Python - Lists, Loops and Conditionals
# Description: A "Who Wants to Be a Millionaire" style quiz game.
#              Uses nested lists to store questions and answers,
#              iterates through questions and breaks on wrong answer.
#              Demonstrates list indexing, f-strings, and for/else logic.

questions = [
    ["What is the capital of Turkey? ", "a- Istanbul", "b- Cankiri", "c- Corum", "d- Ankara", "d"],
    ["What is the name of the Australian hard rock band that took the world by storm in the 1970s?", "a- Metallica", "b- Iron Maiden", "c- AC/DC", "d- Megadeth", "c"],
    ["Which is the formula for water? ", "a- H2O", "b- H2SO4", "c- NaCl", "d- HCl", "a"],
    ["Which country gifted the Statue of Liberty to the USA?", "a- France", "b- Denmark", "c- Spain", "d- Portugal", "a"],
    ["In the quote 'Four wheels carry the body, two wheels carry the soul', what vehicle does 'two wheels' refer to?", "a- Skateboard", "b- Roller skates", "c- Motorcycle", "d- Scooter", "c"]
]

score = 0

for i in range(len(questions)):
    print(f"\n{questions[i][0]}")
    print(questions[i][1])
    print(questions[i][2])
    print(questions[i][3])
    print(questions[i][4])
    answer = input("Enter your answer: ")
    if answer != questions[i][5]:
        print(f"Wrong! You are eliminated. The correct answer was: {questions[i][5]}")
        break
    else:
        score += 100
else:
    print(f"Congratulations, you won the quiz! Your score: {score}")
