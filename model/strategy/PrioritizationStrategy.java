package model.strategy;

import model.Emergency;

public interface PrioritizationStrategy {
    int prioritize(Emergency emergency);

}
