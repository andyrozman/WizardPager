package com.example.android.wizardpager.pod;

import com.example.android.wizardpager.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public enum PodInitActionType {

    PairAndPrimeWizardStep(), //
    PairPod(R.string.omnipod_init_pod_pair_pod, PairAndPrimeWizardStep), //
    PrimePod(R.string.omnipod_init_pod_prime_pod, PairAndPrimeWizardStep), //

    FillCannulaSetBasalProfileWizardStep(),
    FillCannula(R.string.omnipod_init_pod_fill_cannula, FillCannulaSetBasalProfileWizardStep),
    SetBasalProfile(R.string.omnipod_init_pod_set_basal_profile, FillCannulaSetBasalProfileWizardStep);

    private int resourceId;
    private PodInitActionType parent;

    private static Map<PodInitActionType, List<PodInitActionType>> stepsForWizardStep;


    static {
        // TODO

    }


    PodInitActionType(int resourceId, PodInitActionType parent) {
        this.resourceId = resourceId;
        this.parent = parent;
    }


    PodInitActionType() {
    }


    public List<PodInitActionType> getChildren() {

        List<PodInitActionType> outList = new ArrayList<>();

        for (PodInitActionType value : values()) {
            if (value.parent == this) {
                outList.add(value);
            }
        }

        return outList;
    }


    public static List<PodInitActionType> getAvailableWizardSteps(OmnipodPodType podType) {
        List<PodInitActionType> outList = new ArrayList<>();

        if (podType == OmnipodPodType.Eros) {
            outList.add(PodInitActionType.PairAndPrimeWizardStep);
            outList.add(PodInitActionType.FillCannulaSetBasalProfileWizardStep);
        } else {
            // TODO we might have different wizard steps, with different handling for Dash
        }

        return outList;
    }


    public static List<PodInitActionType> getAvailableActionsForWizardSteps(PodInitActionType wizardStep) {
        if (stepsForWizardStep.containsKey(wizardStep)) {
            return stepsForWizardStep.get(wizardStep);
        } else {
            return new ArrayList<>();
        }
    }


    public int getResourceId() {
        return resourceId;
    }
}
