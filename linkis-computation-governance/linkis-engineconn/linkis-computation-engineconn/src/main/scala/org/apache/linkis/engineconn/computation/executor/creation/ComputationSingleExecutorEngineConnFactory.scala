/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package org.apache.linkis.engineconn.computation.executor.creation

import org.apache.linkis.engineconn.common.creation.EngineCreationContext
import org.apache.linkis.engineconn.common.engineconn.EngineConn
import org.apache.linkis.engineconn.computation.executor.execute.ComputationExecutor
import org.apache.linkis.engineconn.core.creation.{AbstractCodeLanguageLabelExecutorFactory, AbstractExecutorFactory}
import org.apache.linkis.manager.engineplugin.common.creation.SingleLabelExecutorEngineConnFactory
import org.apache.linkis.manager.label.entity.Label


trait ComputationSingleExecutorEngineConnFactory
  extends SingleLabelExecutorEngineConnFactory
    with AbstractCodeLanguageLabelExecutorFactory with AbstractExecutorFactory {

  protected override def newExecutor(id: Int,
                            engineCreationContext: EngineCreationContext,
                            engineConn: EngineConn,
                            labels: Array[Label[_]]): ComputationExecutor = null

  override def createExecutor(engineCreationContext: EngineCreationContext,
                              engineConn: EngineConn,
                              labels: Array[Label[_]]): ComputationExecutor =
    createExecutor(engineCreationContext, engineConn)


  override def createExecutor(engineCreationContext: EngineCreationContext,
                              engineConn: EngineConn): ComputationExecutor = {
    super.createExecutor(engineCreationContext, engineConn) match {
      case computationExecutor: ComputationExecutor =>
        computationExecutor.getExecutorLabels().add(getDefaultCodeLanguageLabel)
        computationExecutor
    }
  }

  override protected def createEngineConnSession(engineCreationContext: EngineCreationContext): Any = null

}
