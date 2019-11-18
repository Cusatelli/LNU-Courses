package workshop2.controller;

public enum ACTIONS {
	LIST_COMPACT,
    LIST_VERBOSE,
    
    MEMBER_VIEW,    
    MEMBER_REGISTER,
    MEMBER_EDIT,
    MEMBER_DELETE,
    
    BOAT_REGISTER,
    BOAT_EDIT,
    BOAT_REMOVE,
    
    // Exit Application must always be last in ACTIONS!
    EXIT_APPLICATION;
}
