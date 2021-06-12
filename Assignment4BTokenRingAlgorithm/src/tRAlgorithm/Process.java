package tRAlgorithm;

public class Process {
	public Boolean state;
	public int processId;
	
	public Process(Boolean state, int processId) {
		this.state = state;
		this.processId = processId;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}
	
}
