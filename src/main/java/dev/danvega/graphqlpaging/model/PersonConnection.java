package dev.danvega.graphqlpaging.model;

import java.util.ArrayList;
import java.util.List;

public class PersonConnection {

    private Integer totalCount;
    private PageInfo pageInfo;
    private List<PersonEdge> edges = new ArrayList<>();

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<PersonEdge> getEdges() {
        return edges;
    }

    public void setEdges(List<PersonEdge> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "PersonConnection{" +
                "totalCount=" + totalCount +
                ", pageInfo=" + pageInfo +
                ", edges=" + edges +
                '}';
    }
}
