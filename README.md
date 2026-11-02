# Flash Card system

Lets user manage and save flashcards, as well as use them to study.

## The Problem

In high school, I used Quizlet extensively, which is a website that allows users to create flashcards and offers various ways to go through them to study. However, some of Quizlet's useful features are locked behind a paid subscription, so it is much less useful to me now that I do not have a subscription. I still want to have an easy way to create and study virtual flashcards (physical flashcards are often inconvenient when studying outside of my dorm for short periods of time).

## How It Works

Program uses an Java Arraylist of Card objects to keep track of cards. It allows the user to answer these cards in sequential order, providing feedback on if the answers were right or not. The user is also able to display all current card information and edit, add, or remove cards.

![System diagram](docs/diagram.png)

## Tech Stack

- **Language:** Java
- **Libraries:** ArrayList, PrintWriter, BufferedReader, Scanner
- **External tools:** InteliJ, Github

## Setup

- Download files
- Make sure to have a JVM so that java can run
- Compile Main java file
- Compile Card java file

```bash
git clone https://github.com/woodColumn/FlashCard
cd FlashCard
Javac Main
Javac Card
```

## Usage


Excecute main java file

```bash
Java Main
```

## Roadmap

- Ability to “favorite” certain cards and only study those
- Ability to switch files within program
- Randomized question display order
- Way to organize cards based on number of times gotten incorrect/correct or ratio

## Author

Logan, github.com/woodColumn
