package com.learninghub.learninghub.config;

import com.learninghub.learninghub.entity.Course;
import com.learninghub.learninghub.entity.Subject;
import com.learninghub.learninghub.repository.CourseRepository;
import com.learninghub.learninghub.repository.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;

    public DataInitializer(CourseRepository courseRepository, SubjectRepository subjectRepository) {
        this.courseRepository = courseRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        subjectRepository.deleteAll();
        courseRepository.deleteAll();

        Course cse = courseRepository.save(new Course("Computer Science Engineering (CSE)", "Core Computer Science engineering subjects, software and system architecture.", 0.0));
        List<String> cseSubs = Arrays.asList(
            "1. Data Structures & Algorithms - Core logic and problem solving.",
            "2. Database Management Systems - SQL queries, ER diagrams, normalization.",
            "3. Operating Systems - CPU scheduling, deadlocks, virtual memory.",
            "4. Computer Networks - TCP/IP protocols, routing algorithms, DNS.",
            "5. Software Engineering - Agile development, SDLC models, testing.",
            "6. Object Oriented Programming - Inheritance, encapsulation, polymorphism.",
            "7. Theory of Computation - Automata, Turing machine theory.",
            "8. Compiler Design - Lexical analysis, syntax trees, code generation.",
            "9. Computer Organization - Instruction pipelining, cache memory.",
            "10. Web Technologies - Frontend-backend architecture and HTTP."
        );
        for(String sub : cseSubs) {
            subjectRepository.save(new Subject(sub, "https://www.youtube.com/results?search_query=" + sub.replace(" ", "+") + "+playlist", null, cse));
        }

        Course aiml = courseRepository.save(new Course("Artificial Intelligence & Machine Learning", "Advanced neural networks, machine learning algorithms and AI models.", 0.0));
        List<String> aimlSubs = Arrays.asList(
            "1. Introduction to AI - Intelligent agents and heuristics.",
            "2. Python for Data Science - NumPy, Pandas and data visualization.",
            "3. Supervised Machine Learning - Regression, decision trees, SVM.",
            "4. Unsupervised Learning - K-Means clustering, PCA dimensionality reduction.",
            "5. Deep Learning - Neural networks, CNN, RNN architectures.",
            "6. Natural Language Processing - Text processing, Transformers, LLMs.",
            "7. Computer Vision - OpenCV, image processing, object tracking.",
            "8. Reinforcement Learning - Markov decision processes, Q-learning.",
            "9. AI Ethics & Governance - Algorithmic fairness and bias control.",
            "10. Big Data Analytics - Hadoop and Apache Spark framework."
        );
        for(String sub : aimlSubs) {
            subjectRepository.save(new Subject(sub, "https://www.youtube.com/results?search_query=" + sub.replace(" ", "+") + "+full+course+playlist", null, aiml));
        }

        Course it = courseRepository.save(new Course("Information Technology (IT)", "Enterprise networking, cloud systems, and cybersecurity infrastructure.", 0.0));
        List<String> itSubs = Arrays.asList(
            "1. Information Security - Cryptography, firewalls, and network defense.",
            "2. Cloud Computing - AWS services, virtual machines, serverless.",
            "3. Enterprise Systems - ERP architecture and business integration.",
            "4. Storage Management - SAN, NAS, data recovery techniques.",
            "5. IT Project Management - Risk analysis, Scrum frameworks.",
            "6. Mobile Computing - Android/iOS application development lifecycle.",
            "7. Distributed Systems - Load balancing, fault tolerance.",
            "8. Data Warehousing - ETL pipelines and OLAP cubes.",
            "9. Internet of Things (IoT) - Sensor networks and MQTT protocols.",
            "10. Human Computer Interaction - UI/UX standards and accessibility."
        );
        for(String sub : itSubs) {
            subjectRepository.save(new Subject(sub, "https://www.youtube.com/results?search_query=" + sub.replace(" ", "+") + "+playlist", null, it));
        }

        Course bsc = courseRepository.save(new Course("Bachelor of Science (BSC)", "Fundamental pure and applied sciences including advanced math and physics.", 0.0));
        List<String> bscSubs = Arrays.asList(
            "1. Advanced Calculus - Multivariable functions and integration.",
            "2. Linear Algebra - Vector spaces, matrix decompositions.",
            "3. Quantum Mechanics - Wave functions and Schrödinger equation.",
            "4. Organic Chemistry - Reaction pathways and stereochemistry.",
            "5. Inorganic Chemistry - Coordination chemistry and bonding.",
            "6. Classical Mechanics - Lagrangian and Hamiltonian mechanics.",
            "7. Statistical Physics - Ensembles and thermodynamic laws.",
            "8. Abstract Algebra - Group theory, rings, and fields.",
            "9. Real Analysis - Metric spaces and continuous functions.",
            "10. Numerical Analysis - Error estimation and root finding."
        );
        for(String sub : bscSubs) {
            subjectRepository.save(new Subject(sub, "https://www.youtube.com/results?search_query=" + sub.replace(" ", "+") + "+playlist", null, bsc));
        }

        Course bcom = courseRepository.save(new Course("Bachelor of Commerce (B.COM)", "Corporate accounting, financial management, taxation, and law.", 0.0));
        List<String> bcomSubs = Arrays.asList(
            "1. Financial Accounting - Ledger postings and final statements.",
            "2. Business Economics - Micro and macro market dynamics.",
            "3. Corporate Taxation - Income tax provisions and GST filing.",
            "4. Cost Accounting - Cost sheets and variance analysis.",
            "5. Auditing & Assurance - Internal checks and statutory audits.",
            "6. Business Law - Indian Contract Act and Company Law.",
            "7. Corporate Finance - Capital structure and dividend decisions.",
            "8. Marketing Management - Consumer behavior and brand strategy.",
            "9. Human Resource Management - Talent acquisition and appraisal.",
            "10. E-Commerce - Digital business models and payment systems."
        );
        for(String sub : bcomSubs) {
            subjectRepository.save(new Subject(sub, "https://www.youtube.com/results?search_query=" + sub.replace(" ", "+") + "+playlist", null, bcom));
        }

        Course cProg = courseRepository.save(new Course("C Programming Language", "Procedural coding logic with 20 hands-on practice programs.", 0.0));
        String cPrograms = 
            "1. Hello World Program\n2. Add Two Numbers\n3. Even or Odd Number\n4. Largest of Three Numbers\n" +
            "5. Leap Year Check\n6. Prime Number Verification\n7. Multiplication Table\n8. Factorial using Loops\n" +
            "9. Fibonacci Series Generator\n10. Reverse a Given Number\n11. Palindrome Number Check\n12. Armstrong Number Test\n" +
            "13. Basic Calculator using Switch\n14. Max Element in Array\n15. Bubble Sort Array\n" +
            "16. Matrix Addition Program\n17. Matrix Multiplication\n18. String Length without Function\n" +
            "19. Palindrome String Check\n20. Pointer Swapping Example";
        subjectRepository.save(new Subject("C Language Masterclass & 20 Practice Programs", "https://www.youtube.com/results?search_query=C+Programming+Full+Course+Playlist", cPrograms, cProg));

        Course cppProg = courseRepository.save(new Course("C++ Programming Language", "Object-oriented programming in C++ with 20 practical code examples.", 0.0));
        String cppPrograms = 
            "1. Basic I/O Operations\n2. Class & Object Structure\n3. Constructors & Destructors\n4. Inline Functions\n" +
            "5. Function Overloading\n6. Operator Overloading\n7. Single Inheritance\n8. Multiple Inheritance\n" +
            "9. Multilevel Inheritance\n10. Virtual Functions & Polymorphism\n11. Abstract Classes\n12. Exception Handling (try/catch)\n" +
            "13. Function Templates\n14. Class Templates\n15. STL Vectors Usage\n16. STL Maps & Pairs\n" +
            "17. File Input/Output Streams\n18. Dynamic Memory Allocation\n19. Friend Functions\n20. Encapsulation Principles";
        subjectRepository.save(new Subject("C++ Full Course & 20 Practice Programs", "https://www.youtube.com/results?search_query=C%2B%2B+Programming+Full+Course+Playlist", cppPrograms, cppProg));

        Course javaProg = courseRepository.save(new Course("Java Programming Language", "Enterprise Java backend development with 20 practice applications.", 0.0));
        String javaPrograms = 
            "1. Java Syntax & Data Types\n2. Conditional & Loop Constructs\n3. OOPs Classes & Objects\n4. Method Overloading & Overriding\n" +
            "5. Inheritance & Super Keyword\n6. Interfaces & Abstract Classes\n7. Custom Exception Handling\n8. String Operations\n" +
            "9. ArrayList & List Methods\n10. HashMap & HashSet Implementation\n11. Thread Creation via Thread Class\n12. Runnable Interface Threading\n" +
            "13. FileReader & FileWriter\n14. Lambda Expressions\n15. Java Stream API Operations\n16. JDBC Database Connection\n" +
            "17. Generic Classes & Methods\n18. Garbage Collection Demo\n19. Singleton Design Pattern\n20. Spring Boot REST Endpoint";
        subjectRepository.save(new Subject("Java Full Course & 20 Practice Programs", "https://www.youtube.com/results?search_query=Java+Full+Course+Playlist", javaPrograms, javaProg));

        Course htmlCss = courseRepository.save(new Course("HTML & CSS Web Design", "Modern frontend design with 20 layout and UI components.", 0.0));
        String webPrograms = 
            "1. HTML5 Boilerplate Structure\n2. Headings & Paragraphs\n3. Lists & Links\n4. HTML Tables\n" +
            "5. User Registration Form\n6. Semantic Layout Elements\n7. Inline & Internal CSS\n8. CSS Box Model\n" +
            "9. Flexbox Navbar\n10. Flexbox Card Grid\n11. CSS Grid Layout\n12. Responsive Media Queries\n" +
            "13. Hover Effects & Transitions\n14. Custom Styled Buttons\n15. Login Form UI Design\n16. Pricing Card Component\n" +
            "17. Flexbox Image Gallery\n18. CSS Animations Keyframes\n19. Footer Component\n20. Complete Portfolio Landing Page";
        subjectRepository.save(new Subject("HTML & CSS Masterclass & 20 Web Components", "https://www.youtube.com/results?search_query=HTML+CSS+Full+Course+Playlist", webPrograms, htmlCss));
    }
}