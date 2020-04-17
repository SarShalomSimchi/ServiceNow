# ServiceNow - The TasK
 You have a file describing the output of a private investigator following his target.
The file has many sentences, one in a row.
The private investigator uses consistent phrasing to describe what is going on. Only one word can change in a
specific phrase/pattern.
The input may look like:
```
01-01-2012 19:45:00 Naomi is getting into the car
01-01-2012 20:12:39 Naomi is eating at a restaurant
02-01-2012 09:13:15 George is getting into the car
02-01-2012 10:14:00 George is eating at a diner
03-01-2012 10:14:00 Naomi is eating at a diner
```
1. Your task is to write code that groups together similar sentences
   (sentences where only a single word has changed)
   and extracts the changes, then outputs them to a file in the following format:
   ```
   =====
   01-01-2012 19:45:00 Naomi is getting into the car
   02-01-2012 09:13:15 George is getting into the car
   The changing word was: Naomi, George
   02-01-2012 10:14:00 George is eating at a diner
   03-01-2012 10:14:00 Naomi is eating at a diner
   The changing word was: Naomi, George
   =====
   ```
2. Please upload your code to GitHub and send me a link.
   Make sure to also upload a sample input file. Alongside the code, please answer the following questions:
    - What can you say about the complexity of your code?
    - How will your algorithm scale?If you had two weeks to do this task, what would you have done differently?
    -- What would be better?

# ServiceNow - Answers
1. Done.
2. You can find the code [here](https://github.com/SarShalomSimchi/ServiceNow/tree/master/ServiceNow)
   And Here is an input example:
   ```
   01-01-2012 19:45:00 Naomi is getting into the car 
   01-01-2012 20:12:39 Naomi is eating at a restaurant
   02-01-2012 09:13:15 George is getting into the car
   02-01-2012 10:14:00 George is eating at a diner   
   02-01-2012 10:14:00 George is getting into the house     
   03-01-2012 10:14:00 Naomi is eating at a diner    
   03-01-2012 10:14:10 Naomi is eating at a friend    
   03-01-2012 10:14:20 Naomi is eating at a diner    
   03-01-2012 10:14:20 Naomi is drinking at a diner    
   ```
  - What can you say about the complexity of your code?
    - O(n * k) -> O(n) where n for lines and k for number of words in a line

  - How will your algorithm scale, If you had two weeks to do this task, what would you have done differently?
    What would be better?
    - I don't think I would change the algorithm, I think I would have change the general design of the app, maybe use an iterator for the Analyzer.
