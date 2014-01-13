package com.prevoty.smartfilter.client;

import java.util.ArrayList;

public class TrustedQueryResult {
  public ArrayList<TrustedQueryStatementViolation> statement_violations;
  public ArrayList<TrustedQueryFieldViolation> field_violations;
  public ArrayList<TrustedQueryFunctionViolation> function_violations;
}
