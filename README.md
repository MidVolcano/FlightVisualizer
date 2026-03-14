# **Flight Visualizer**

Mini Full stack Spring Boot + Leaflet.js app that visualizes flight routes from airport CSV data.
Currently Features: Tracking Airport Location and Visualizing the flight to get there.
Currently In Development: The ability to put in a flights commercial flight number and visualize its flight path.

## **Tech Used** 

### **Front End**
- HTML
- JavaScript
- Leaflet.js (The visual map)

### **Back End**
- Java
- Spring Boot
- REST

## **How It Looks Before & After**
Before Input:
<img width="1675" height="852" alt="Screenshot 2025-11-14 at 8 37 24 PM" src="https://github.com/user-attachments/assets/e7263f46-0cfc-44c7-8892-0c0f7f9ea071" />
After Input:
<img width="1675" height="852" alt="Screenshot 2025-11-14 at 8 37 52 PM" src="https://github.com/user-attachments/assets/0131b966-3dee-48f7-9be7-8bb09e373f58" />
<img width="1675" height="852" alt="Screenshot 2025-11-14 at 8 38 27 PM" src="https://github.com/user-attachments/assets/fb039ccb-d6f9-43e6-b3e6-e9156c490925" />

## **Optimizations**
- The source code is body readable and easily understood since most of the java code should be understood by anyone proficient in java.
- Handles API limits by stopping the program early if it exceeds current funds in my OPENAI account and if there is an API error, it is printed to console.
- A visual map representation to actually visualize the data.

## **Setup Instructions**
Prerequisites:
- Java (I used 25 for this)
- Maven for Spring Boot
- The endpoints for the GET are **/airport** and for seeing the website its ### **/map.html**
  
### **Running the Project in Eclipse**

1. **Download the repository**

Download the ZIP from GitHub and extract it.

---

2. **Open Eclipse**

Start Eclipse and make sure you have the following installed:

- Maven 

---

3. **Import the Project**

In Eclipse (Correct on my MacBook):

1. Click **File**
2. Click **Import**
3. Select **Maven**
4. Choose **Existing Maven Projects**
5. Click **Next**

---

4. **Select the Project Folder**

Click **Browse** and navigate to the project folder you downloaded.

Eclipse should do the rest automatically

---

5. **Run the Project**

Open the **FlightTrackerApplication** file and right click it
Choose to run as java application

The server will then run on your browser specifically at:

```
http://localhost:8080
```

---

7. **Open the Website**

Once the application is running, open your browser go  to:

```
http://localhost:8080/map.html
```
---

Endpoints available:

```
GET map.html
GET /airport
```
## **Key Decisions / Trade Offs**

One of the main design decisions for this project was choosing the backend language and framework. I chose Java with Spring Boot because Java is the language I have the most experience with, and I wanted to further develop my skills working with Spring Boot and REST in specific.

While building this project, I recognized that using **Python** would have probably made my life easier especially for the map portion but I personally prefer Java, and gained more from writing this in java (Specifically all the debugging) than had I done this in python.

## **Improvements With Time**

As of now for this project, the most annoying part for me was doing the webpage. I am decent at HTML and JavaScript but as my skills improve, I would like to come back to this project and really update the Front-End ui. I would also wish to add in more error handeling and a database since this was stored locally.

## Architecture Decisions (Brief)

### Backend Framework: Java + Spring Boot
I chose **Java with Spring Boot** because it is widely used in industry specifically backend systems. Spring Boot makes it straightforward to build **REST APIs**, and was relatively easy to learn.

### REST API Design
The application exposes two endpoints:
- `GET /map.html`
- `GET /airport`

### Time Spent
This project took me around 12 hours split among 4 days

### Frontend Dashboard
A simple **HTML + JavaScript** front end was chosen 

The Website:
- displays the reconciled medication
- shows AI generated reasoning
- maps the confidence scores using Chart.js to a pie chart 

---

## Test Data / Example Requests

### Flight Input Example
(They all have to be .TXT)

Request:

```txt
flight,origin,destination
AA101,LAX,JFK
DL202,SFO,ORD
UA303,SEA,DFW

```

---

Five more test cases are included in the download aswell. (At src/test/java)



