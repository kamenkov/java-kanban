package org.kamenkov.java_kanban.task;

import org.kamenkov.java_kanban.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class EpicImpl extends TaskImpl implements Epic {

    /* Hides the superclass field to prohibit manual updates */
    private Status status;
    private final List<Subtask> subtasks;
    private static final Type type = Type.EPIC;

    public EpicImpl(String summary, String description) {
        super(summary, description);
        subtasks = new ArrayList<>();
        recalculateStatus();
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public List<Subtask> getSubtaskObjects() {
        return subtasks;
    }

    @Override
    public void addSubtask(Subtask subtask) {
        if (subtask != null) {
            subtasks.add(subtask);
            recalculateStatus();
        }
    }

    @Override
    public void removeSubtask(Subtask subtask) {
        if (subtask != null) {
            subtasks.remove(subtask);
            recalculateStatus();
        }
    }

    @Override
    public void recalculateStatus() {
        if (subtasks.isEmpty()) {
            status = Status.NEW;
            return;
        }
        Set<Status> subtaskStatuses = subtasks.stream().map(Subtask::getStatus).collect(Collectors.toSet());
        if (subtaskStatuses.size() == 1) {
            status = subtaskStatuses.stream().findFirst().orElse(Status.NEW);
            return;
        }
        status = Status.IN_PROGRESS;
    }

    @Override
    public String toString() {
        return getId() + "," + type + "," + getSummary() + "," + getStatus() + "," + getDescription() + ","
                + getStartDate() + "," + getDurationInMinutes() + "," + getEndDate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EpicImpl epic = (EpicImpl) o;

        return Objects.equals(subtasks, epic.subtasks);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (subtasks != null ? subtasks.hashCode() : 0);
        return result;
    }
}
