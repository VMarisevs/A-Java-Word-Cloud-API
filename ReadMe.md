# Advanced Object-Oriented Design Principles & Patterns
# Main Assignment 2015
# A Java Word Cloud API
## [GitHub](https://github.com/VMarisevs/A-Java-Word-Cloud-API) will be available after submission date

# Overview
Word-clouds are a mechanism for creating a visual representation of text and are used to
display a visual summary of the most prominent words used on a web page, a news forum or
a social media web site. A word-cloud is comprised of a set of tags, with each tag
representing a single word. The prominence of a word is typically estimated from its
occurrence frequency in a text and is visualised using a large font size or different font colour.

This Java Word-Cloud API can parse a file or a URL to
generate a PNG (portable network graphics) file with a word-cloud displaying the most
prominent words in decreasing font size, style and colour. Note that this API can ignore
frequently occurring words and HTML tags, in the case of a word-cloud generated from a
URL. A list of common words is provided in the file stopwords.txt.



# UML Class diagram
![alt tag](https://github.com/VMarisevs/A-Java-Word-Cloud-API/blob/master/design.png)
This diagram was generated using [ObjectAid UML Diagram](http://www.objectaid.com/) plugin for Eclipse.



# Extras + Features

### Ant build script
This Ant build.xml prepares whole project for submission:
* Before compiling all classes, it automatically downloads JUnit library and inserts it into class path
* Compiles all Classes in ./src folder and moves them into ./dist folder
* Generates ./dist/wordcloud.jar file, excluding JUnit tests
* Main-Class specification allows to run this .jar using *java -jar wordcloud.jar* command

### API
* This API have GUI that makes it easy to use.
* Word cloud prints words in ascending order ([credit to Lars Vogel for Quick Sort Algorithm implementation](http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html)).
* User can manually load several stopwords files, and map will be populated (NOT OVERRIDDEN), stopword files must be formated same as original file. (Note that we can try to generate without stopwords)
* In case user will try to generate from URL, all tags wil be ignored. And this project is not using any sub libraries to do that.
* Quick help for users who are not reading readme files in actual application at run time.
* Also developers signature and link to GitHub project.



# How to use
Load stopwords *File => Load* select stopwords.txt or a similar formatted file to populate map of words to be ignored.

You can use "Browse" button to select text file to generate Word Cloud or provide valid URL. It will ask you to type in .png file name.
 
# How to run
### import into eclipse
**!NOTE** don't forget to import JUnit:
**To do that:**
Project properties => Java Build Path => Libraries => Add Library
Select JUnit, Next => Finish

Run Runner.java in ie.gmit.sw package

### build project using Ant
I assume that we are in project folder.
building this project using ant
> $ ant

> $ cd ./dist

> $ java -jar wordcloud.jar
OR
> $ java -cp ./wordcloud.jar ie.gmit.sw.Runner
