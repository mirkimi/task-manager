package com.project.tms.enums;

public enum TaskStatusEnum {

    PENDING ("P", "Pending"),
    COMPLETED ("C", "Completed");

    private final String code;
    private final String displayName;

    TaskStatusEnum(String code, String displayName){
        this.code = code;
        this.displayName = displayName;
    }

    public String getCode(){
        return code;
    }

    public String getDisplayName(){
        return displayName;
    }

    public static TaskStatusEnum fromRequest(String request){
        for(TaskStatusEnum taskStatusEnum : TaskStatusEnum.values()){
            if(taskStatusEnum.getCode().equalsIgnoreCase(request) ||
            taskStatusEnum.getDisplayName().equalsIgnoreCase(request)){
                return taskStatusEnum;
            }
        }
        throw new IllegalArgumentException(("Unknown task status: " + request));
    }

    public static String getCodeFromRequest(String request){
        for(TaskStatusEnum taskStatusEnum : TaskStatusEnum.values()){
            if(taskStatusEnum.getCode().equalsIgnoreCase(request) ||
                    taskStatusEnum.getDisplayName().equalsIgnoreCase(request)){
                return taskStatusEnum.getCode();
            }
        }
        throw new IllegalArgumentException(("Unknown task status: " + request));
    }

    public static String getDisplayNameFromCode(String code){
        for(TaskStatusEnum taskStatusEnum : TaskStatusEnum.values()){
            if(taskStatusEnum.getCode().equalsIgnoreCase(code)){
                return taskStatusEnum.getDisplayName();
            }
        }
        throw new IllegalArgumentException(("Unknown task status: " + code));
    }
}
