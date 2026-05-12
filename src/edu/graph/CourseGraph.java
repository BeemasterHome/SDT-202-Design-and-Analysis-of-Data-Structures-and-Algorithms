package edu.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Stores course names and maps them to integer vertices used by Digraph.
 */
public class CourseGraph {
    private final Map<String, Integer> courseToId = new LinkedHashMap<>();
    private final List<String> idToCourse = new ArrayList<>();
    private Digraph graph;

    public CourseGraph(List<String[]> edges, List<String> standaloneCourses) {
        for (String course : standaloneCourses) {
            addCourse(course);
        }
        for (String[] edge : edges) {
            addCourse(edge[0]);
            addCourse(edge[1]);
        }

        graph = new Digraph(idToCourse.size());
        for (String[] edge : edges) {
            graph.addEdge(courseToId.get(edge[0]), courseToId.get(edge[1]));
        }
    }

    public Digraph graph() {
        return graph;
    }

    public String courseName(int id) {
        return idToCourse.get(id);
    }

    public int size() {
        return idToCourse.size();
    }

    private void addCourse(String course) {
        if (!courseToId.containsKey(course)) {
            courseToId.put(course, idToCourse.size());
            idToCourse.add(course);
        }
    }
}
