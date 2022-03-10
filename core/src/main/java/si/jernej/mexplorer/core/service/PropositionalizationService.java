package si.jernej.mexplorer.core.service;

import javax.enterprise.context.Dependent;

import si.jernej.mexplorer.processorapi.v1.model.WordificationConfigDto;
import si.jernej.mexplorer.processorapi.v1.model.WordificationResultDto;

@Dependent
public class PropositionalizationService
{

    /**
     * Compute Wordification results with the specified configuration.
     *
     * @param wordificationConfigDto configuration for the Wordification algorithm
     * @return Wordification algorithm results in the specified format
     */
    public WordificationResultDto computeWordification(WordificationConfigDto wordificationConfigDto)
    {
        return null;
    }

}
