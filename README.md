## Machine Checker

### Intent

Machine Checker is a tool to check that a DFA has been properly 
constructed by testing if, given a string, it provides the correct 
classification. It is meant to be used as a study aide by students 
studying DFA construction.

For example, we examine a motivating problem, "construct a DFA M such 
that L(M) = L where L is the set of all strings over {0,1} with exactly 
two occurances of the substring 01000111." Students may construct a DFA 
for such a language, but may have a hard time verifying its correctness. 
It is trivial to construct examples and counter-examples of words for L, 
so students may use this program and examples they come up with to 
ensure the correctness of their DFA, or to aide in its design. 

Given a deterministic finite automata M, an input string w, and
classification X (YES w is in L or NO w is NOT in L), determine whether 
M correctly classifies w. That is, if we run M on w, does the output 
match X? 

Note that his program does NOT mathematically verify that L(M) = L. This 
problem is non-trivial. This program only verifies that a DFA M, given 
w, does or does not match the classification of w provided by the user. 

### Usage

#### 1. Construct the DFA

The DFA M is defined by the user in the machine.csv file, which has the 
following format:

!! TODO WRITE THE FORMAT HERE !!

#### 2. Command line usage

// TODO: correct this
machine_checker [word] [Y/N]

### TODO

- Make a trello board
- Unit tests for machine construction
- Construct DFA from file
	- Define input file format
	- New DFA constructor
	- Let user define the input file as an optional 
parameter
- Run against a batch of examples/counter-examples to determine correctness
	- User classification of examples
	- Batch == store examples/read from file, I think
- Equivalence testing with RegEx
- Equivalence testing with other DFAs
- Graphical interface
- Context free grammars and deterministic pushdown automata?

### Further development

#### Equivalence with Regular Expressions and other DFAs 

We must check the DFA against examples because this program is intended 
for use with problems such as those specified in the intent section of 
this document. However, this leaves something to be desired, i.e. this 
program does not mathematically prove L(M) = L. To do so with our 
motivating example is impossible, however it is possible if L is defined 
as a regular expression or as another known DFA (i.e. in a 
way that our computer may interpret). This is because equivalence of 
two regular languages is a decidable problem, so we may compare the 
languages of the given DFA/RegEx and the user's DFA. 

Doing so would be useful for a number of reasons, but recall that this 
program is meant to be an educational tool. Given that, proving L(M) = L 
for a user-constructed M would be useful for:

(1) Transformation-type problems. That is, given a RegEx defining L, 
construct an equivalent DFA. If this program can test for the 
equivalence of a RegEx and any given DFA, students may check their 
answers easily.

(2) Homework assignments or guided studying. A set of problems such as 
those in our intent may be given by the instructor, who may then provide 
the program with (hidden) DFAs/RegEx's defining that language which act 
as an answer key. The program may then check the student's answers for 
equivalence to the answer key. 

#### Guided lessons

Provide a graphical interface for the construction of a DFA. When a user 
runs a string through the machine, it shows step-by-step the internal 
mechanisms of the DFA to help the user gain an intuition for how DFAs 
work. Guide the user through constructing progressively 
more complex DFAs, giving feedback (written and visual) to help. 


#### Going up the hierarchy

Expand for context free grammars/pushdown automata, etc...
