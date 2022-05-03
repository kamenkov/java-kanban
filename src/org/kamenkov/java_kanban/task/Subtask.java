package org.kamenkov.java_kanban.task;

public interface Subtask extends Task {

    /**
     * Gets the unique ID of the parent {@link Epic}.
     * @return parent {@link Epic} id.
     */
    Long getParentId();

}